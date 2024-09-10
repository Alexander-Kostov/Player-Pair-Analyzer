import React from 'react';
import Match from './Match';

export default function Branch({ branchId, matches }) {
    const matchComponents = matches.map((match, index) => {
       return <Match key={index} matchId={index} match={match}></Match>
    })

    return (
        <div className={`branch_${branchId}`}>
            {matchComponents}
        </div>
    )
}