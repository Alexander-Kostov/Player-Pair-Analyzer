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
    console.log(teamA)
    
    const positionAMap = {
        GK: [playersA.find(player => player.position === 'GK')],
        DF: playersA.filter(player => player.position === 'DF'),
        MF: playersA.filter(player => player.position === 'MF'),
        FW: playersA.filter(player => player.position === 'FW')
    };

    const positionBMap = {
        GK: [playersB.find(player => player.position === 'GK')],
        DF: playersB.filter(player => player.position === 'DF'),
        MF: playersB.filter(player => player.position === 'MF'),
        FW: playersB.filter(player => player.position === 'FW')
    };

    console.log(playersA)
    return (
        <div className="match-details-container">
            <div className="field-image">
                <p className="team-name">{teamA.name}</p>
                <img src="/images/football-field.png" alt="No image found" />

                <div className="field-players">
                    <div className="row player-gk">
                        {positionAMap.GK[0] && (
                            <div className="player">
                                {positionAMap.GK[0].fullName}
                            </div>
                        )}
                    </div>
                    <div className="row player-df">
                        {positionAMap.DF.map((player, index) => (
                            <div key={player.id} className="player">
                                {player.fullName}
                            </div>
                        ))}
                    </div>
                    <div className="row player-mf">
                        {positionAMap.MF.map((player, index) => (
                            <div key={player.id} className="player">
                                {player.fullName}
                            </div>
                        ))}
                    </div>
                    <div className="row player-fw">
                        {positionAMap.FW.map((player, index) => (
                            <div key={player.id} className="player">
                                {player.fullName}
                            </div>
                        ))}
                    </div>
                </div>
            </div>
            {<p className="score">{match?.score}</p>}

            <div className="field-image">
                <p className="team-name">{teamB.name}</p>
                <img src="/images/football-field.png" alt="No image found" />
                <div className="field-players">
                    <div className="row player-gk">
                        {positionBMap.GK[0] && (
                            <div className="player">
                                {positionBMap.GK[0].fullName}
                            </div>
                        )}
                    </div>
                    <div className="row player-df">
                        {positionBMap.DF.map((player, index) => (
                            <div key={player.id} className="player">
                                {player.fullName}
                            </div>
                        ))}
                    </div>
                    <div className="row player-mf">
                        {positionBMap.MF.map((player, index) => (
                            <div key={player.id} className="player">
                                {player.fullName}
                            </div>
                        ))}
                    </div>
                    <div className="row player-fw">
                        {positionBMap.FW.map((player, index) => (
                            <div key={player.id} className="player">
                                {player.fullName}
                            </div>
                        ))}
                    </div>
                </div>
            </div>
        </div>
    )
}