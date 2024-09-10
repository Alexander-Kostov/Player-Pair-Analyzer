import React from 'react';

export default function Match({ matchId, match }) {
    const { teamAName, teamBName, score } = match;
    const scoreExtracted = score.split('-');
    console.log(teamAName)


    return (
        <div className='match'>
            <div className='object'>
                <div className='teams'>
                    <div className='team'>{teamAName} {scoreExtracted[0]}</div>
                    <div className='team'>{teamBName} {scoreExtracted[1]}</div>
                </div>
            </div>
        </div>
    );
}