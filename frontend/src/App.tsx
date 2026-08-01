
import { BrowserRouter, Routes, Route } from 'react-router';
import { Toaster, toast } from 'sonner';
import Homepage from './pages/Homepage';
import ViewProduct from './pages/ViewProduct';

function App() {
  return (
    <>
      <Toaster />
      <button onClick={() => toast("hello")}>Toaster</button>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Homepage />} />
          <Route path="/product/:id" element={<ViewProduct />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
