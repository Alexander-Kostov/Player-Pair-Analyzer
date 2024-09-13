import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

export function useGetTournamentData() {
    return useQuery({
        queryKey: ['matches'],
        queryFn: async () => {
            const response = await axios.get('http://localhost:8080/meets/tournament-data');
            return response.data;
        },
        staleTime: 10000
    });
}