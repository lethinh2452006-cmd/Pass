
import { BrowserRouter, Routes, Route } from 'react-router';
import { Toaster } from 'sonner';
import Homepage from './pages/Homepage';
import ViewProduct from './pages/ViewProduct';

function App() {
  return (
    <>
      <Toaster />
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Homepage />} />
          <Route path="/product" element={<ViewProduct />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
