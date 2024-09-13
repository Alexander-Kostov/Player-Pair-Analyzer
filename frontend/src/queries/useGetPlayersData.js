import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

export function useGetPlayersData() {
    return useQuery({
        queryKey: ['all-players'],
        queryFn: async () => {
            const response = await axios.get('http://localhost:8080/players/all');
            return response.data;
        },
        staleTime: 10000 
    });
}