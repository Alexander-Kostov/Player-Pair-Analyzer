import { useNavigate } from 'react-router-dom';
import '../css/lasting-duos.css';

export default function LastingDuosTable({ data, title, iconClass, navigateTo, divPageClass }) {
    const navigate = useNavigate();

    if (!data) {
        return <div>No data available</div>;
    }

    const maxTime = Math.max(...data.map(item => item.totalTimeTogether));
    const filteredParticipation = data.filter(item => item.totalTimeTogether === maxTime);

    const handleIconClick = () => {
        navigate(navigateTo);
    };

    return (
        <div className="table-container">
            <h1>{title}</h1>
            <div></div>
            <table>
                <thead>
                    <tr>
                        <th>Player 1</th>
                        <th>Player 2</th>
                        <th>Total Time Together</th>
                        <th>Match Times</th>
                    </tr>
                </thead>
                <tbody>
                    {filteredParticipation.map((item, index) => (
                        <tr key={index}>
                            <td>{item.player1}</td>
                            <td>{item.player2}</td>
                            <td>{item.totalTimeTogether}</td>
                            <td>{item.matchTimes}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <div className={divPageClass}>
                <i className={iconClass} onClick={handleIconClick}>
                    <div className='hover-text'><p>{title}</p></div>
                </i>
            </div>
        </div>
    );
}