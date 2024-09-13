import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

export function useGetGroupData() {
    return useQuery({
        queryKey: ['group-data'],
        queryFn: async () => {
            const response = await axios.get('http://localhost:8080/meets/group-data');
            return response.data.reduce((acc, match) => {
                if (!acc[match?.group]) {
                    acc[match?.group] = [];
                }
                acc[match?.group].push(match);
                return acc;
            }, {});
        },
        staleTime: 10000
    });
}