import '../css/teams.css'
import { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';

export default function Teams() {

    const [teams, setTeams] = useState([]);
    const [loading, setLoading] = useState(true);
    const navigate = useNavigate();

    useEffect(() => {
        fetch('http://localhost:8080/teams/without-players')
            .then((response) => response.json())
            .then((data) => {
                setTeams(data);
                setLoading(false)
            })
            .catch((error) => {
                console.error('Error fetching teams:', error);
            });
    }, []);

    if (loading) {
        return <div>Loading...</div>
    }

    const handleRowClick = (teamId) => {
        navigate(`/teams/${teamId}`);
    };

    return (
        <div className="teams-container">
            <h1>Teams</h1>

            <table border="1">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Group Name</th>
                        <th>Manager</th>
                        <th>Country</th>
                    </tr>
                </thead>
                <tbody>
                    {teams.map((team) => (
                            <tr key={team.id} onClick={() => handleRowClick(team.id)}>
                                <td>{team.id}</td>
                                <td>{team.groupName}</td>
                                <td>{team.manager}</td>
                                <td>{team.name}</td>
                            </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}