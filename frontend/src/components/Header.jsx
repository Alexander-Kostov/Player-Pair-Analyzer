import { Link } from 'react-router-dom';

export default function Header() {

    const pages = [
        { title: 'Home', path: '/', position: 'left' },
        { title: 'Teams', path: '/teams', position: 'left' },
        { title: 'Players', path: '/players', position: 'left' },
        { title: 'Matches', path: '/matches', position: 'left' },

        { title: 'Participations', path: '/participations', position: 'right' },
        { title: 'Lasting Duos', path: '/participations/lasting-duos', position: 'right' },
    ];

    return (
        <header>
            <nav className="site-nav">
                <ul className="nav-left">
                    {pages
                        .filter(page => page.position === 'left')
                        .map(({ title, path }) => (
                            <li key={title}>
                                <Link to={path}>{title}</Link>
                            </li>
                        ))}
                </ul>

                <ul className="nav-right">
                    {pages
                        .filter(page => page.position === 'right')
                        .map(({ title, path }) => (
                            <li key={title}>
                                <Link to={path}>{title}</Link>
                            </li>
                        ))}
                </ul>
            </nav>
        </header>
    )
}