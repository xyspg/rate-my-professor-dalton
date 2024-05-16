import React from 'react';

const Hero = () => {
    return (
        <div className='flex flex-col p-8 md:p-14'>
            <h1 className='text-6xl font-bold font-mono'>Rate My <span className='text-red-900'>Professor</span></h1>
            <p className='text-sm mt-4 font-mono'>Find the best professors at Dalton Academy</p>
        </div>
    );
};

export default Hero;