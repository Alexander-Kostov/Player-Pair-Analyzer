import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";

export default function TeamDetails() {
    const {teamId} = useParams();

    const [team, setTeam] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetch(`http://localhost:8080/teams/${teamId}`)
            .then((response) => response.json())
            .then((data) => {
                setTeam(data);
                setLoading(false)
            })
            .catch((error) => {
                console.error('Error fetching teams:', error);
            });
    }, []);

    if (loading) {
        return <div>Loading...</div>
    }


    return (
        <div className="table-container">
            <h1>{team[0].teamName + ' Players'}</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>Team Number</th>
                        <th>Player Name</th>
                        <th>Position</th>
                    </tr>
                </thead>
                <tbody>
                    {team.map((team) => (
                            <tr key={team.id}>
                                <td>{team.playerNumber}</td>
                                <td>{team.playerName}</td>
                                <td>{team.playerPosition}</td>
                            </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}