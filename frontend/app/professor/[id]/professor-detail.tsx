"use client"
import React, { useState } from 'react';
import {Professor} from "@/lib/types";
import {toast} from "sonner";
import {useRouter} from "next/navigation";
import Link from "next/link";

interface ProfessorDetailProps extends React.HTMLAttributes<HTMLDivElement> {
    data: Professor;
}
const ProfessorDetail = ({ data }: ProfessorDetailProps) => {
    const [remark, setRemark] = useState("");
    const [rating, setRating] = useState(0);
    const router = useRouter()

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault()
        const newRating = {
            professorId: data.id,
            rating: rating,
            remark: remark
        };
        const response = await fetch("http://localhost:8080/ratings/update", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(newRating)
        });
        if (!response.ok) toast.error("Failed to submit rating");
        else {
            toast.success("Rating submitted successfully");
            setRemark("");
            setRating(0);
            router.refresh();
        }

    }
    return (
        <div className="p-24">
            <Link href='/'>Go Back</Link>
            <div className="flex flex-col items-center">
                <div className="text-center">
                    <div className="text-6xl font-bold">{data.rating.toFixed(2)} / 5</div>
                    <div className="text-lg">
                        Overall Quality Based on {data.ratings.length} ratings
                    </div>
                    <div className="text-4xl font-bold mt-4">Professor: {data.name}</div>
                    <div className="text-lg">
                        Professor in the {data.department} department at Dalton Academy
                    </div>
                </div>

                <div className="bg-gray-100 p-6 mt-8 w-full max-w-4xl mx-auto">
                    <h2 className="text-2xl font-bold mb-4">
                        Check out similar professors in the {data.department} department
                    </h2>
                    <div className="flex space-x-4">
                        {data.professorsInOtherDepartments.map((professor) => (
                            <div
                                key={professor.id}
                                className="bg-blue-400 text-white text-center p-4 rounded-md"
                            >
                                <div className="text-2xl font-bold">{professor.rating}</div>
                                <div className="text-black font-semibold mt-2">
                                    {professor.name}
                                </div>
                            </div>
                        ))}
                    </div>
                </div>
                <div className="w-full mt-8">
                    <div className="text-left text-lg font-bold mb-4">Comments</div>
                    <form className="mb-6" onSubmit={handleSubmit}>
                        <div className="flex flex-col w-full">
                            <input
                                type="text"
                                className="p-2 w-full border rounded shadow mb-2"
                                placeholder="Add a comment..."
                                value={remark}
                                onChange={(e) => setRemark(e.target.value)}
                            />
                            <input
                                type="number"
                                className="p-2 w-52 border rounded shadow mb-2"
                                placeholder="Rating (0.0-5.0)"
                                value={rating}
                                onChange={(e) => setRating(parseFloat(e.target.value))}
                                />
                            <div className="flex justify-end">
                                <button
                                    type="submit"
                                    className="bg-blue-500 text-white py-2 px-4 rounded"
                                >
                                    Submit
                                </button>
                            </div>
                        </div>
                    </form>
                    <div className="flex flex-col space-y-4">
                        {data?.ratings?.map((rating: any) => (
                            <div key={rating.id} className="p-4 border rounded shadow">
                                <div className="text-gray-700">{rating.remark}</div>
                            </div>
                        ))}
                    </div>
                </div>
            </div>
        </div>
    );
};

export default ProfessorDetail;