import { Button } from "@/components/ui/button";
const Danhmuc = () => {
  return (
    <div>
        <div className="w-full h-48 bg-blue-200 text-gray-800 px-6 py-4 flex items-center justify-between">
            <Button variant="default">Thêm danh mục</Button>
            <h2 className="text-xl font-bold">Danh mục</h2>
        </div>
    </div>
  );
};

export default Danhmuc;