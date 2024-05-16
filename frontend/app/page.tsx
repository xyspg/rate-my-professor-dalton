import Image from "next/image";
import Hero from "@/components/hero";
import ProfessorList from "@/components/professor-list";

export default function Home() {
  return (
    <main className="flex min-h-screen flex-col justify-start items-center p-24">
      <Hero />
      <ProfessorList />
    </main>
  );
}
