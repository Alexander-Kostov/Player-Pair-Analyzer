import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

export function useGetTeamsData() {
    return useQuery({
        queryKey: ['teams'],
        queryFn: async () => {
            const response = await axios.get('http://localhost:8080/teams/without-players');
            return response.data;
        },
        staleTime: 10000 
    });
}