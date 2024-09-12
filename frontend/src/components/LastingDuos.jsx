import { useState, useEffect } from "react";

export default function LastingDuos() {

    const [participation, setParticipation] = useState([]);
    const [filteredParticipation, setFilteredParticipation] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetch('http://localhost:8080/participations/most-time')
            .then((response) => response.json())
            .then((data) => {
                setParticipation(data);
                setLoading(false)
            })
            .catch((error) => {
                console.error('Error fetching teams:', error);
            });
    }, []);

    useEffect(() => {
        if (participation.length > 0) {
            const maxTime = Math.max(...participation.map(item => item.totalTimeTogether));
            
            const filtered = participation.filter(item => item.totalTimeTogether === maxTime);
            
            setFilteredParticipation(filtered);
        }
    }, [participation]);

    if (loading) {
        return <div>Loading...</div>
    }

    return (
       <div className="table-container">
            <h1>Players With Most Mutual Time</h1>
            <table>
                <thead>
                    <tr>
                        <th>Player 1</th>
                        <th>Player 2</th>
                        <th>Total Time Together</th>
                    </tr>
                </thead>
                <tbody>
                    {filteredParticipation.map((item, index) => (
                        <tr key={index}>
                            <td>{item.player1}</td>
                            <td>{item.player2}</td>
                            <td>{item.totalTimeTogether}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}