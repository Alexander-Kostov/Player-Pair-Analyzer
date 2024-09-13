import '../css/teams.css'
import { useGetTeamsData } from '../queries/useGetTeamsData';

import { Link, useNavigate } from 'react-router-dom';

export default function Teams() {

    const { data: teams, error, isLoading } = useGetTeamsData();
    const navigate = useNavigate();

    if (isLoading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error fetching teams: {error.message}</div>;
    }

    const handleRowClick = (teamId) => {
        navigate(`/teams/${teamId}`);
    };

    return (
        <div className="table-container">
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
                            <tr key={team.id} onClick={() => handleRowClick(team.id)} className='teams-row'>
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