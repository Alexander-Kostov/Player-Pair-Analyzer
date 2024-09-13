import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

export function useGetMostTimeDuosFromDifferentTeams() {
    return useQuery({
        queryKey: ['most-time-duos-from-different-teams'],
        queryFn: async () => {
            const response = await axios.get('http://localhost:8080/participations/different-teams-time');
            return response.data;
        },
        staleTime: 10000 
    });
}