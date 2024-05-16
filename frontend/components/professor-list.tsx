import React from 'react';
import {Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle} from "@/components/ui/card";
import { FaStar } from "react-icons/fa6";


const ProfessorList = () => {
    const data = [
        {
            'name': 'Wei Sai',
            'department': 'Mathematics',
        },
        {
            'name': 'Ma Jiyun',
            'department': 'Physics',
        },
        {
            'name': 'Zhang Weibo',
            'department': 'Biology',

        }
    ]
    return (
        <div className='flex flex-row gap-4'>
            {data.map(professor => (
                <Card key={professor.name}>
                    <CardHeader>
                        <CardTitle>{professor.name}</CardTitle>
                        <CardDescription>{professor.department}</CardDescription>
                    </CardHeader>
                    <CardContent className='flex flex-row gap-1 items-center'>
                        <FaStar /><p>5.0</p>
                    </CardContent>
                </Card>
            ))}

        </div>
    );
};

export default ProfessorList;