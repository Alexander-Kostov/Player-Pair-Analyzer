import { useGetPlayersData } from "../../queries/useGetPlayersData";

export default function Players() {
    const { data: players, error, isLoading } = useGetPlayersData();

    if (isLoading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error fetching team details: {error.message}</div>;
    }

    if (!players || players.length === 0) {
        return <div>No players available.</div>;
    }


    return (
        <div className="table-container">
            <h1>All Players Present</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>Player ID</th>
                        <th>Player Name</th>
                        <th>Position</th>
                        <th>Team</th>
                    </tr>
                </thead>
                <tbody>
                    {players.map((players) => (
                        <tr key={players.id}>
                            <td>{players.id}</td>
                            <td>{players.fullName}</td>
                            <td>{players.position}</td>
                            <td>{players.teamName}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}