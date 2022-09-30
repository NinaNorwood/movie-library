import {ChangeEvent, useState} from "react";


type NewMovieProps = {
    newMovie : (title:string, posterUrl:string, year:string) => void
}
export default function NewMovie(props : NewMovieProps) {

    const [title, setTitle] = useState("")
    const [posterUrl, setPosterUrl] = useState("")
    const [year, setYear] = useState("")

    const onTitleChange = (event: ChangeEvent<HTMLInputElement>) => {
        setTitle(event.target.value)
    }
    const onPosterUrlChange = (event: ChangeEvent<HTMLInputElement>) => {
        setPosterUrl(event.target.value)
    }
    const onYearChange = (event: ChangeEvent<HTMLInputElement>) => {
        setYear(event.target.value)
    }

    return (
        <div>
            <label>Title
                <input onChange={onTitleChange} value={title} />
            </label>
            <label>posterURL
                <input onChange={onPosterUrlChange} value={posterUrl} />
            </label>
            <label>Year
                <input onChange={onYearChange} value={year} />
            </label>
            <button onClick={() => props.newMovie(title,posterUrl,year)}>Add Book</button>
        </div>

    )

}