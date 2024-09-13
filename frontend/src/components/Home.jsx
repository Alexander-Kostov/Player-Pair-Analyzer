import Branch from './tournament/Branch';
import '../css/tournament.css';
import { useGetTournamentData } from '../queries/useGetTournamentData';
import { useGetGroupData } from '../queries/useGetGroupData';

export default function Home() {
    const { data: matchesData = [], isLoading: matchesLoading, error: matchesError } = useGetTournamentData();

    const { data: groupedMatchesData = [], isLoading: groupedMatchesLoading, error: groupedMatchesError } = useGetGroupData();

    if (matchesLoading || groupedMatchesLoading) {
        return <div>Loading...</div>;
    }

    if (matchesError || groupedMatchesError) {
        return <div>Error fetching data!</div>;
    }

    const groupKeys = Object.keys(groupedMatchesData);
    const halfwayPoint = Math.ceil(groupKeys.length / 2);
    const firstHalfGroups = groupKeys.slice(0, halfwayPoint);
    const secondHalfGroups = groupKeys.slice(halfwayPoint);

    const tournamentFinals = matchesData.slice(0, 15);
    const roundOf16th = tournamentFinals.slice(7);
    const quarterFinals = tournamentFinals.slice(3, 7);
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
                                {groupedMatchesData[groupName].map(match => (
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
                                {groupedMatchesData[groupName].map(match => (
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
