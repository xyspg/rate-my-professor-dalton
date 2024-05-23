import React from "react";

const Page = ({params: {id}}: { params: { id: string } }) => {
    const data = {
        "id": 2,
        "name": "劳拉西泮",
        "department": "Chemistry",
        "rating": 4.75,
        "ratings": [
            {
                "id": 1,
                "professorId": 2,
                "rating": 4.5,
                "remark": "very good"
            },
            {
                "id": 2,
                "professorId": 2,
                "rating": 5,
                "remark": "great"
            }
        ]
    }

    return (
        // <div className='p-24'>
        //   <h1>Professor Page</h1>
        //   <p>Professor ID: {id}</p>
        // </div>
        <div className="p-24">
            <div className="flex flex-col items-center">
                <div className="text-center">
                    <div className="text-6xl font-bold">{data.rating} / 5</div>
                    <div className="text-lg">Overall Quality Based on {data.ratings.length} ratings</div>
                    <div className="text-4xl font-bold mt-4">Professor: {data.name}</div>
                    <div className="text-lg">Professor in the Computer Science department at Dalton Academy</div>
                </div>
                {/*<div className="flex flex-row justify-between w-full mt-8">*/}
                {/*    <div className="flex flex-col items-center w-1/3">*/}
                {/*        <div className="text-4xl font-bold">0%</div>*/}
                {/*        <div className="text-lg">Would take again</div>*/}
                {/*    </div>*/}
                {/*    <div className="flex flex-col items-center w-1/3">*/}
                {/*        <div className="text-4xl font-bold">2.8</div>*/}
                {/*        <div className="text-lg">Level of Difficulty</div>*/}
                {/*    </div>*/}
                {/*</div>*/}
                {/*<div className="flex flex-row justify-around w-full mt-8">*/}
                {/*  <button className="bg-blue-500 text-white py-2 px-4 rounded">Rate</button>*/}
                {/*  <button className="border border-blue-500 text-blue-500 py-2 px-4 rounded">Compare</button>*/}
                {/*</div>*/}
                {/*<div className="flex flex-row justify-center items-center w-full mt-8">*/}
                {/*  <div className="text-lg">Check out Similar Professors in the Computer Science Department</div>*/}
                {/*</div>*/}
                <div className="bg-gray-100 p-6 mt-8 w-full max-w-4xl mx-auto">
                    <h2 className="text-2xl font-bold mb-4">Check out Similar Professors in the Computer Science
                        Department</h2>
                    <div className="flex space-x-4">
                        <div className="bg-blue-400 text-white text-center p-4 rounded-md">
                            <div className="text-2xl font-bold">5.00</div>
                            <div className="text-black font-semibold mt-2">喹硫平</div>
                        </div>
                        <div className="bg-blue-400 text-white text-center p-4 rounded-md">
                            <div className="text-2xl font-bold">3.30</div>
                            <div className="text-black font-semibold mt-2">奥氮平</div>
                        </div>
                        <div className="bg-blue-400 text-white text-center p-4 rounded-md">
                            <div className="text-2xl font-bold">2.90</div>
                            <div className="text-black font-semibold mt-2">氯氮平</div>
                        </div>
                    </div>
                </div>
                <div className="w-full mt-8">
                    <div className="text-left text-lg font-bold mb-4">Comments</div>
                    <form className="mb-6">
                        <div className="flex flex-col w-full">
                            <input
                                type="text"
                                className="p-2 w-full border rounded shadow mb-2"
                                placeholder="Add a comment..."
                            />
                            <div className="flex justify-end">
                                <button type="submit" className="bg-blue-500 text-white py-2 px-4 rounded">Submit
                                </button>
                            </div>
                        </div>
                    </form>
                    <div className="flex flex-col space-y-4">
                        {/*<div className="p-4 border rounded shadow">*/}
                        {/*    <div className="font-bold">Student A</div>*/}
                        {/*    <div className="text-gray-700">The lectures are very hard to follow and the grading is very*/}
                        {/*        strict.*/}
                        {/*    </div>*/}
                        {/*</div>*/}
                        {/*<div className="p-4 border rounded shadow">*/}
                        {/*    <div className="font-bold">Student B</div>*/}
                        {/*    <div className="text-gray-700">Not helpful at all during office hours. Would not*/}
                        {/*        recommend.*/}
                        {/*    </div>*/}
                        {/*</div>*/}
                        {/*<div className="p-4 border rounded shadow">*/}
                        {/*    <div className="font-bold">Student C</div>*/}
                        {/*    <div className="text-gray-700">The assignments are too difficult and there is no guidance.*/}
                        {/*    </div>*/}
                        {/*</div>*/}
                        {data.ratings.map(rating => (
                            <div key={rating.id} className="p-4 border rounded shadow">
                                <div className="text-gray-700">{rating.remark}
                                </div>
                            </div>
                        ))}
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Page;
