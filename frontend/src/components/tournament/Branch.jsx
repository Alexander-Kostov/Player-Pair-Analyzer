import React from 'react';
import Match from './Match';

export default function Branch({ branchId, matches }) {
    const matchComponents = matches.map((match, index) => {
       return <Match key={index} matchId={index} match={match}></Match>
    })

    const getTitle = () => {
        switch (branchId) {
            case "1":
                return "Round Of 16th";
            case "2":
                return "Quarter-Finals";
            case "3":
                return "Semi-Finals";
            case "4":
                return "Finals";
            default:
                return "";
        }
    };

    return (
        <div className={`branch_${branchId}`}>
            <h2 className='tournament-bracket-title'>{getTitle(branchId)}</h2>
            {matchComponents}
        </div>
    )
}