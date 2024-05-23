import React from "react";

const Page = ({ params: { id } }: { params: { id: string } }) => {

  return (
    <div className='p-24'>
      <h1>Professor Page</h1>
      <p>Professor ID: {id}</p>
    </div>
  );
};

export default Page;
