
const Header = () => {
  return (
    <div className="w-full h-20 bg-[#3a2323] text-white px-6 py-4 flex items-center justify-between">
      {/* Logo */}
      <div className="w-32 h-15 bg-rose-400 rounded-full flex items-center justify-center text-sm font-bold">
      MyLogo
      </div >
        <div className="flex items-center gap-24" >
        {/* Navigation */}
        <nav className="flex items-center gap-12 text-lg font-semibold"
        style={{marginRight: 'auto' }}
        >
          <a href="#" className="hover:text-rose-300 transition-colors">Về chúng tôi</a>
          <a href="#" className="hover:text-rose-300 transition-colors">Liên hệ</a>
          <a href="#" className="hover:text-rose-300 transition-colors">Sản phẩm</a>
          <a href="#" className="hover:text-rose-300 transition-colors">Vé workshop</a>
        </nav>

        {/* Search */}
        <div 
          className="flex items-center w-48 md:w-96 h-12 rounded-full bg-gray-100 border border-transparent focus-within:ring-2 focus-within:ring-rose-400 focus-within:bg-white transition-all"
          style={{ paddingLeft: '16px', paddingRight: '16px', paddingTop: '8px', paddingBottom: '8px', gap: '10px', marginRight: '8px' }}
        >
          <svg 
            className="h-5 w-5 text-gray-500 shrink-0" 
            fill="none" 
            stroke="currentColor" 
            viewBox="0 0 24 24"
            style={{ marginLeft: '16px' }}
          >
            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" />
          </svg>
          <input
            type="text"
            placeholder="Search"
            className="w-full bg-transparent border-none outline-none text-black text-md placeholder:text-gray-400 font-semibold focus:outline-none focus:ring-0"
            style={{ padding: 0, margin: 0 }}
          />
        </div>
      </div>
    </div>
  );
};

export default Header;