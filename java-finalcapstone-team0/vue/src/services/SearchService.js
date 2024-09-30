import axios from 'axios';

const http = axios.create({
  baseURL:import.meta.env.VITE_REMOTE_API
});




const searchService = {
    async search(query, table) {
      try {
        // Check if table is defined
        if (!table) {
          throw new Error('Table name is not provided');
        }
        
        const response = await axios.get(`http://localhost:9000/${table}/search`, {
          params: { query },
        });
        return response.data; // Return the search results
      } catch (error) {
        console.error('Error performing search:', error);
        throw error; // Re-throw the error for handling in the component
      }
    }
  };
  
  export default searchService;