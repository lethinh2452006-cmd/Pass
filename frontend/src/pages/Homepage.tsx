import New from "@/components/New";
import Header from "../components/Header";


const Homepage = () => {
    return (
        <div className="w-full h-full bg-white" >
            <div className="w-full bg-white position-sticky top-0 ">
            <Header />
            </div>
            <div className="w-full h-full flex items-center justify-center">
                <New />
            </div>
            <div>
                
            </div>
        </div>
    )
}

export default Homepage