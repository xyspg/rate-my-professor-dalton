import React from "react";
import { Professor } from "@/lib/types";
import ProfessorDetail from "@/app/professor/[id]/professor-detail";

const Page = async ({ params: { id } }: { params: { id: string } }) => {
  const data = (await fetch(
    `http://localhost:8080/professors/getById?id=${id}`,
  ).then((res) => res.json())) as Professor;
  console.log(data);

  return <ProfessorDetail data={data} />;
};

export default Page;
