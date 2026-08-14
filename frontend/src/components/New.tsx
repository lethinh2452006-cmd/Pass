
import { Swiper, SwiperSlide } from 'swiper/react';
import { Autoplay, Navigation, Pagination } from 'swiper/modules';

// Import Swiper styles
import 'swiper/css';
import 'swiper/css/navigation';
import 'swiper/css/pagination';

const newsItems = [
  { id: 1, title: 'Tin tức 1', description: 'Nội dung thông tin tin tức số 1 được cập nhật mới nhất.' },
  { id: 2, title: 'Tin tức 2 (Chính giữa)', description: 'Nội dung thông tin tin tức số 2 nổi bật nhất hôm nay.' },
  { id: 3, title: 'Tin tức 3', description: 'Nội dung thông tin tin tức số 3 với nhiều sự kiện hấp dẫn.' },
  { id: 4, title: 'Tin tức 4', description: 'Nội dung thông tin tin tức số 4 tổng hợp tuần qua.' },
  { id: 5, title: 'Tin tức 5', description: 'Nội dung thông tin tin tức số 5 về công nghệ và đời sống.' },
];

const New = () => {
  return (
    <div className="w-full min-h-96 py-8 bg-white flex items-center justify-center">
      <div className="w-full ">
        <Swiper
          modules={[Autoplay, Pagination, Navigation]}
          spaceBetween={20}
          slidesPerView={1.6}
          centeredSlides={true}
          loop={true}
          autoplay={{
            delay: 3000,
            disableOnInteraction: false,
          }}
          pagination={{ clickable: true }}
          navigation={false}
          breakpoints={{
            640: {
              slidesPerView: 2,
              spaceBetween: 20,
            },
            1024: {
              slidesPerView: 2.2,
              spaceBetween: 30,
            },
          }}
          className="w-full py-6"
        >
          {newsItems.map((item) => (
            <SwiperSlide key={item.id} className="py-4">
              {({ isActive }) => (
                <div
                  className={`rounded-3xl p-6 transition-all duration-300 h-84 flex flex-col justify-between select-none ${
                    isActive
                      ? 'bg-white shadow-2xl scale-100 border-2 border-rose-300 opacity-100'
                      : 'bg-gray-300 opacity-60 scale-95'
                  }`}
                >
                  <div>
                    <h3 className="font-bold text-xl text-gray-800 mb-3">
                      {item.title}
                    </h3>
                    <p className="text-gray-600 text-base leading-relaxed">{item.description}</p>
                  </div>
                  <span className="text-sm text-rose-500 font-semibold cursor-pointer hover:underline">
                    Xem chi tiết →
                  </span>
                </div>
              )}
            </SwiperSlide>
          ))}
        </Swiper>
      </div>
    </div>
  );
};

export default New;
