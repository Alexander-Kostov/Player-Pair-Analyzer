import React from 'react';
import { Link } from 'react-router-dom';

export default function Match({ match }) {
    const { teamAName, teamBName, score } = match;
    const scoreExtracted = score.split('-');
    const matchId = match.id;
    // const showMatchInfo = () => {
    //     console.log()
    // }

    return (
        <div className='match'>
            <div className='object'>
                <div className='teams'>
                    <Link to={`/matches/${matchId}`} className='teams'>
                        <div className='team'>{teamAName + ':'} {scoreExtracted[0]}</div>
                        <div className='team'>{teamBName + ':'} {scoreExtracted[1]}</div>
                    </Link>
                </div>
            </div>
        </div>
    );
}