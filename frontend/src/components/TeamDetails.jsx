import { useGetTeamDetails } from '../queries/useGetTeamDetails';

export default function TeamDetails() {
    const { data: team, error, isLoading } = useGetTeamDetails();

    if (isLoading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error fetching team details: {error.message}</div>;
    }

    if (!team || team.length === 0) {
        return <div>No team details available.</div>;
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