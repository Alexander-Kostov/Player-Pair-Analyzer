import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";


export default function SingleMatchComponent() {

    const { matchId } = useParams()

    const [match, setMatch] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {

        fetch(`http://localhost:8080/meets/${matchId}/details`)
            .then(response => response.json())
            .then(data => {
                setMatch(data);
                setLoading(false);
            })
            .catch(error => {
                console.error('Error fetching match details:', error);
                setLoading(false);
            });
    }, []);

    if (loading || !match) {
        return <div>Loading...</div>
    }

    const teamA = match.teamADTO;
    const teamB = match.teamBDTO;

    const playersA = teamA.players.slice(0, 11);
    const playersB = teamB.players.slice(0, 11);
    
    const positionMap = {
        GK: [playersA.find(player => player.position === 'GK')],
        DF: playersA.filter(player => player.position === 'DF'),
        MF: playersA.filter(player => player.position === 'MF'),
        FW: playersA.filter(player => player.position === 'FW')
    };


    console.log(playersA)
    return (
        <div className="match-details-container">
            <div className="field-image">
                <p className="team-name">{teamA.name}</p>
                <img src="/images/football-field.png" alt="No image found" />

                <div key={positionMap.GK[0].id} className="player player-gk">
                    {positionMap.GK[0].fullName}
                </div>

                {positionMap.DF.map((player, index) => {
                   return <div key={player.id} className={`player player-df df-${index}`}> {player.fullName}</div>
                })}

                {positionMap.MF.map((player, index) => {
                    return <div key={player.id} className={`player player-mf mf-${index}`}>{player.fullName}</div>
                })}
                
                {positionMap.FW.map((player, index) => {
                    return <div key={player.id} className={`player player-fw fw-${index}`}>{player.fullName}</div>
                })}
            </div>

            {<p className="score">{match?.score}</p>}

            <div className="field-image">
                <p className="team-name">{teamB.name}</p>
                <img src="/images/football-field.png" alt="No image found" />
               
             
            </div>
        </div>
    )
}