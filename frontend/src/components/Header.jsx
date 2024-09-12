import { Link } from 'react-router-dom';

export default function Header() {

    const pages = [
        { title: 'Home', path: '/', position: 'left', icon: 'fa-solid fa-house' },
        { title: 'Teams', path: '/teams', position: 'left', icon: 'fa-solid fa-people-group' },
        { title: 'Players', path: '/players', position: 'left', icon: 'fa-solid fa-user' },

        { title: 'Participations', path: '/participations', position: 'right', icon: 'fa-solid fa-clock' },
        { title: 'Lasting Duos', path: '/participations/lasting-duos', position: 'right', icon: 'fa-solid fa-people-arrows' },
    ];

    return (
        <header>
            <nav className="site-nav">
                <ul className="nav-left">
                    <li>
                        <Link to="/">
                            <img src="/images/cup.png" alt="Cup" className="nav-logo" />
                        </Link>
                    </li>
                    {pages
                        .filter(page => page.position === 'left')
                        .map(({ title, path, icon }) => (
                            <li key={title}>
                                <Link to={path}>
                                    <div className='nav-item'>
                                        <i className={icon}></i>
                                        <p>{title}</p>
                                    </div>
                                </Link>
                            </li>
                        ))}
                </ul>

                <ul className="nav-right">
                    {pages
                        .filter(page => page.position === 'right')
                        .map(({ title, path, icon }) => (
                            <li key={title}>
                                <Link to={path}>
                                    <div className='nav-item'>
                                        <i className={icon}></i>
                                        <p>{title}</p>
                                    </div>
                                </Link>
                            </li>
                        ))}
                </ul>
            </nav>
        </header>
    )
}