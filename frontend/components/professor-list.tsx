import React from 'react';
import {Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle} from "@/components/ui/card";
import { FaStar } from "react-icons/fa6";
import Link from "next/link";


const ProfessorList = async () => {
    const data = await fetch("http://localhost:8080/professors").then(res => res.json());

    return (
        <div className='flex flex-row flex-wrap gap-4'>
            {data.map((professor: any) => (
                <Card key={professor.id}>
                    <Link href={`/professor/${professor.id}`}>
                    <CardHeader>
                        <CardTitle>{professor.name}</CardTitle>
                        <CardDescription>{professor.department}</CardDescription>
                    </CardHeader>
                    <CardContent className='flex flex-row gap-1 items-center min-w-40'>
                        <FaStar />
                        <p>5.0</p>
                    </CardContent>
                    </Link>
                </Card>
            ))}

        </div>
    );
};

export default ProfessorList;