import { useEffect, useState } from 'react';
import Branch from './tournament/Branch';
import '../css/tournament.css';

export default function Home() {
    const [matchesData, setMatchesData] = useState([]);
    const [groupedMatches, setGroupedMatches] = useState({});
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetch('http://localhost:8080/meets/tournament-data')
            .then(response => response.json())
            .then(data => {
                setMatchesData(data)
                setLoading(false)
            })
            .catch(error => {
                console.error('Error fetching data:', error)
                setLoading(false)
            });
    }, []);

    useEffect(() => {
        fetch("http://localhost:8080/meets/group-data")
            .then(response => response.json())
            .then(data => {
                const grouped = data.reduce((acc, match) => {
                    if (!acc[match?.group]) {
                        acc[match?.group] = [];
                    }
                    acc[match?.group].push(match);
                    return acc;
                }, {});

                setGroupedMatches(grouped);
                setLoading(false)
            })
            .catch(error => console.error("Error fetching data:", error));
    }, []);

    if (loading) {
        return <div>Loading...</div>;
    }

    const groupKeys = Object.keys(groupedMatches);
    const halfwayPoint = Math.ceil(groupKeys.length / 2);
    const firstHalfGroups = groupKeys.slice(0, halfwayPoint);
    const secondHalfGroups = groupKeys.slice(halfwayPoint);

    const tournamentFinals = matchesData.slice(0, 15)

    const roundOf16th = tournamentFinals.slice(7);
    const quarterFinals = tournamentFinals.slice(3, 7)
    const semiFinals = tournamentFinals.slice(1, 3);
    const finals = [tournamentFinals[0]];

    return (
        <div className="container">
            <div className="first-half-groups">
                {firstHalfGroups.map(groupName => (
                    <div key={groupName}>
                        <h2 className='table-group-name'>Group {groupName}</h2>
                        <table border="1" className='group-table'>
                            <thead>
                                <tr>
                                    <th>Team A</th>
                                    <th>Team B</th>
                                    <th>Score</th>
                                </tr>
                            </thead>
                            <tbody>
                                {groupedMatches[groupName].map(match => (
                                    match && (
                                        <tr key={match.id}>
                                            <td>{match.teamAName}</td>
                                            <td>{match.teamBName}</td>
                                            <td>{match.score}</td>
                                        </tr>
                                    )
                                ))}
                            </tbody>
                        </table>
                    </div>
                ))}
            </div>
            <div className='tournament-container'>
                <Branch branchId="1" matches={roundOf16th} />
                <Branch branchId="2" matches={quarterFinals} />
                <Branch branchId="3" matches={semiFinals} />
                <Branch branchId="4" matches={finals} />
            </div>

            <div className="second-half-groups">
                {secondHalfGroups.map(groupName => (
                    <div key={groupName}>
                        <h2 className='table-group-name'>Group {groupName}</h2>
                        <table border="1" className='group-table'>
                            <thead>
                                <tr>
                                    <th>Team A</th>
                                    <th>Team B</th>
                                    <th>Score</th>
                                </tr>
                            </thead>
                            <tbody>
                                {groupedMatches[groupName].map(match => (
                                    match && (
                                        <tr key={match.id}>
                                            <td>{match.teamAName}</td>
                                            <td>{match.teamBName}</td>
                                            <td>{match.score}</td>
                                        </tr>
                                    )
                                ))}
                            </tbody>
                        </table>
                    </div>
                ))}
            </div>
        </div>
    )
}