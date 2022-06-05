export class Movie{
    constructor(
        public movie_id : number = 0,
        public movie_name : string = '',
        public status : string = '',
        public language : string = '',
        public genre : string = '',
        public format : string = ''
    ){}
}