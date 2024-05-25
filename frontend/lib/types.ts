interface Rating {
    id: number;
    professorId: number;
    rating: number;
    remark: string;
}

export interface Professor {
    id: number;
    name: string;
    department: string;
    rating: number;
    ratings: Rating[];
    professorsInOtherDepartments: Professor[];
}