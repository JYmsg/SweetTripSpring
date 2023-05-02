/**
 * Template Name: Kelly
 * Updated: Mar 10 2023 with Bootstrap v5.2.3
 * Template URL: https://bootstrapmade.com/kelly-free-bootstrap-cv-resume-html-template/
 * Author: BootstrapMade.com
 * License: https://bootstrapmade.com/license/
 */
(function () {
  "use strict";

  /**
   * Easy selector helper function
   */
  const select = (el, all = false) => {
    el = el.trim();
    if (all) {
      return [...document.querySelectorAll(el)];
    } else {
      return document.querySelector(el);
    }
  };

  /**
   * Easy event listener function
   */
  const on = (type, el, listener, all = false) => {
    let selectEl = select(el, all);
    if (selectEl) {
      if (all) {
        selectEl.forEach((e) => e.addEventListener(type, listener));
      } else {
        selectEl.addEventListener(type, listener);
      }
    }
  };

  /**
   * Easy on scroll event listener
   */
  const onscroll = (el, listener) => {
    el.addEventListener("scroll", listener);
  };

  /**
   * Scrolls to an element with header offset
   */
  const scrollto = (el) => {
    let header = select("#header");
    let offset = header.offsetHeight;

    let elementPos = select(el).offsetTop;
    window.scrollTo({
      top: elementPos - offset,
      behavior: "smooth",
    });
  };

  /**
   * Back to top button
   */
  let backtotop = select(".back-to-top");
  if (backtotop) {
    const toggleBacktotop = () => {
      if (window.scrollY > 100) {
        backtotop.classList.add("active");
      } else {
        backtotop.classList.remove("active");
      }
    };
    window.addEventListener("load", toggleBacktotop);
    onscroll(document, toggleBacktotop);
  }

  /**
   * Mobile nav toggle
   */
  on("click", ".mobile-nav-toggle", function (e) {
    select("#navbar").classList.toggle("navbar-mobile");
    this.classList.toggle("bi-list");
    this.classList.toggle("bi-x");
  });

  /**
   * Mobile nav dropdowns activate
   */
  on(
    "click",
    ".navbar .dropdown > a",
    function (e) {
      if (select("#navbar").classList.contains("navbar-mobile")) {
        e.preventDefault();
        this.nextElementSibling.classList.toggle("dropdown-active");
      }
    },
    true
  );

  /**
   * Scrool with ofset on links with a class name .scrollto
   */
  on(
    "click",
    ".scrollto",
    function (e) {
      if (select(this.hash)) {
        e.preventDefault();

        let navbar = select("#navbar");
        if (navbar.classList.contains("navbar-mobile")) {
          navbar.classList.remove("navbar-mobile");
          let navbarToggle = select(".mobile-nav-toggle");
          navbarToggle.classList.toggle("bi-list");
          navbarToggle.classList.toggle("bi-x");
        }
        scrollto(this.hash);
      }
    },
    true
  );

  /**
   * Scroll with ofset on page load with hash links in the url
   */
  window.addEventListener("load", () => {
    if (window.location.hash) {
      if (select(window.location.hash)) {
        scrollto(window.location.hash);
      }
    }
  });

  /**
   * Preloader
   */
  let preloader = select("#preloader");
  if (preloader) {
    window.addEventListener("load", () => {
      preloader.remove();
    });
  }

  /**
   * Porfolio isotope and filter
   */
  window.addEventListener("load", () => {
    let portfolioContainer = select(".portfolio-container");
    if (portfolioContainer) {
      let portfolioIsotope = new Isotope(portfolioContainer, {
        itemSelector: ".portfolio-item",
      });

      let portfolioFilters = select("#portfolio-flters li", true);

      on(
        "click",
        "#portfolio-flters li",
        function (e) {
          e.preventDefault();
          portfolioFilters.forEach(function (el) {
            el.classList.remove("filter-active");
          });
          this.classList.add("filter-active");

          portfolioIsotope.arrange({
            filter: this.getAttribute("data-filter"),
          });
          portfolioIsotope.on("arrangeComplete", function () {
            AOS.refresh();
          });
        },
        true
      );
    }
  });

  /**
   * Initiate portfolio lightbox
   */
  const portfolioLightbox = GLightbox({
    selector: ".portfolio-lightbox",
  });

  /**
   * Initiate portfolio details lightbox
   */
  const portfolioDetailsLightbox = GLightbox({
    selector: ".portfolio-details-lightbox",
    width: "90%",
    height: "90vh",
  });

  /**
   * Portfolio details slider
   */
  new Swiper(".portfolio-details-slider", {
    speed: 400,
    loop: true,
    autoplay: {
      delay: 5000,
      disableOnInteraction: false,
    },
    pagination: {
      el: ".swiper-pagination",
      type: "bullets",
      clickable: true,
    },
  });

  /**
   * Skills animation
   */
  let skilsContent = select(".skills-content");
  if (skilsContent) {
    new Waypoint({
      element: skilsContent,
      offset: "80%",
      handler: function (direction) {
        let progress = select(".progress .progress-bar", true);
        progress.forEach((el) => {
          el.style.width = el.getAttribute("aria-valuenow") + "%";
        });
      },
    });
  }

  /**
   * Testimonials slider
   */
  new Swiper(".testimonials-slider", {
    speed: 600,
    loop: true,
    autoplay: {
      delay: 5000,
      disableOnInteraction: false,
    },
    slidesPerView: "auto",
    pagination: {
      el: ".swiper-pagination",
      type: "bullets",
      clickable: true,
    },
  });

  /**
   * Animation on scroll
   */
  window.addEventListener("load", () => {
    AOS.init({
      duration: 1000,
      easing: "ease-in-out",
      once: true,
      mirror: false,
    });
  });

  /**
   * Initiate Pure Counter
   */
  new PureCounter();
})();
const kakaokey = "";

window.addEventListener("load", show_map);
var map;
function show_map() {
  var mapContainer = document.getElementById("map"), // 지도를 표시할 div
    mapOption = {
      center: new kakao.maps.LatLng(37.500701, 127.036907), // 지도의 중심좌표
      level: 3, // 지도의 확대 레벨
    };

  map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

  // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
  var mapTypeControl = new kakao.maps.MapTypeControl();

  // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
  // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
  map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

  // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
  var zoomControl = new kakao.maps.ZoomControl();
  map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

  set_markup();
}

let festival_key = "CIph4Ep9WZIczZRzxN3VnWaqSnt22CGUzr0ykamQMkhFmozlHUowzXKwYrYJKpNAdkfaBrwZakZoFCoIc9gVkQ%3D%3D";

let location_url = ``;

let search_code = "12"; // 관광지를 디폴로 설정

let sido_code = "6"; // 부산 디폴트
let gungo_code = "8"; // 군구 코드로 -> 키워드 값을 맵핑 시켜준다.
let search_string = "북구"; //키워드 디폴트sss

// 부산 6 북구 8
function search() {
  fetch(url, get);
}

function set_markup() {
  var markerPosition = new kakao.maps.LatLng(37.500701, 127.036907);

  // 마커를 생성합니다
  var marker = new kakao.maps.Marker({
    position: markerPosition,
  });

  // 마커가 지도 위에 표시되도록 설정합니다
  marker.setMap(map);
}

// document.querySelector("#inlineCheckbox1").addEventListener("change", function () {
//   console.log("!!!");
// });
// value에 따라서 fetch함수 url 변경되도록 하는 함수 구현

/* <div class="swiper-slide">
<div class="testimonial-item">
  <img src="assets/img/testimonials/testimonials-5.jpg" class="testimonial-img" alt="">
  <h3>John Larson</h3>
  <h4>Entrepreneur</h4>
  <p>
    <i class="bx bxs-quote-alt-left quote-icon-left"></i>
    Quis quorum aliqua sint quem legam fore sunt eram irure aliqua veniam tempor noster veniam enim culpa
    labore duis sunt culpa nulla illum cillum fugiat legam esse veniam culpa fore nisi cillum quid.
    <i class="bx bxs-quote-alt-right quote-icon-right"></i>
  </p>
</div>
</div><!-- End testimonial item --> */

function slider_fun() {
  let src = `<div class="swiper-slide">
    <div class="testimonial-item">
      <img src="assets/img/testimonials/testimonials-5.jpg" class="testimonial-img" alt="">
      <h3>John Larson</h3>
      <h4>Entrepreneur</h4>
      <p>
        <i class="bx bxs-quote-alt-left quote-icon-left"></i>
        Quis quorum aliqua sint quem legam fore sunt eram irure aliqua veniam tempor noster veniam enim culpa
        labore duis sunt culpa nulla illum cillum fugiat legam esse veniam culpa fore nisi cillum quid.
        <i class="bx bxs-quote-alt-right quote-icon-right"></i>
      </p>
    </div>
    </div><!-- End testimonial item -->`;
}
//function login() {
//  var userid = document.getElementById("ID").value;
//  var userpw = document.getElementById("password").value;
//  console.log(userid);
//  console.log(userpw);
//    document.querySelector(".login-before").style.display = "none";
//    document.querySelector(".login-after").style.display = "block";
//  } else {
//    alert("아이디 또는 비밀번호 확인!!!");
//  }
//}
//function logout() {
//  document.querySelector(".login-after").style.display = "none";
//  document.querySelector(".login-before").style.display = "block";
//}
