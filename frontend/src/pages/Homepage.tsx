import New from "@/components/New";
import Header from "../components/Header";
import Danhmuc from "@/components/Danhmuc";


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
                <Danhmuc />
            </div>
        </div>
    )
}

export default Homepage