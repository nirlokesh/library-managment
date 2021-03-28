export class Book{
    id : number;
    name : string;
    description : string;
    count : number;
}

export class LibraryResponse{
    library : Library;
}

export class Library{
    bookList : Array<Book>;
    borrowList:any;
}

