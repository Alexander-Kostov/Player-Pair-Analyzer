import {useEffect, useState} from 'react';
import Branch from './tournament/Branch';
import '../css/tournament.css';

export default function Home() {
    const [matchesData, setMatchesData] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetch('http://localhost:8080/meets/tournament-data')
            .then(response => response.json())
            .then(data =>  {
                setMatchesData(data)
                setLoading(false)
            })
            .catch(error => {
                console.error('Error fetching data:', error)
                setLoading(false)
            });
    }, []);

    if (loading) {
        return <div>Loading...</div>;
    }

    const tournamentFinals = matchesData.slice(0, 15)
    const groups = matchesData.slice(15);

    const roundOf16th = tournamentFinals.slice(7);
    const quarterFinals = tournamentFinals.slice(3, 7)
    const semiFinals = tournamentFinals.slice(1, 3);
    const finals = [tournamentFinals[0]];

    return (
        <div className="container">
            <Branch branchId="1" matches={roundOf16th} />
            <Branch branchId="2" matches={quarterFinals} />
            <Branch branchId="3" matches={semiFinals} />
            <Branch branchId="4" matches={finals} />
        </div>
    )
}