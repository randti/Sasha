import axios from 'axios';

const Book_API_BASE_URL = 'http://localhost:8080/api/books';

class BookService{

    getBooks(){
        return axios.get(Book_API_BASE_URL);
    }
}

export default new BookService();