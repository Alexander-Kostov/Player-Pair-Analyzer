import { useGetParticipationsData } from "../queries/useGetParticipationsData";

export default function Participations() {
    const { data: participations, error, isLoading } = useGetParticipationsData();

    if (isLoading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error fetching team details: {error.message}</div>;
    }

    if (!participations || participations.length === 0) {
        return <div>No participations available.</div>;
    }


    return (
        <div className="table-container">
            <h1>All Player Participations In Matches</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>Participation ID</th>
                        <th>Player Id</th>
                        <th>Match Id</th>
                        <th>From Minutes</th>
                        <th>To Minutes</th>
                    </tr>
                </thead>
                <tbody>
                    {participations.map((participation) => (
                        <tr key={participation.id}>
                            <td>{participation.id}</td>
                            <td>{participation.playerId}</td>
                            <td>{participation.meetId}</td>
                            <td>{participation.fromMinutes}</td>
                            <td>{participation.toMinutes}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}