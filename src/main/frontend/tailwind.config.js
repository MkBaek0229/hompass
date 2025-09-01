/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["../resources/templates/**/*.{html,js,mustache}"], // mustache는 사용하지 않을 경우 삭제
  theme: {

    extend: {
     keyframes: {
            animate: {
                  '0%':   { backgroundPosition: '0 100px' },
                  '10%':  { backgroundPosition: '0 100px' },
                  '40%':  { backgroundPosition: '1000px -70px' },
                  '80%':  { backgroundPosition: '2000px -80px' },
                  '100%': { backgroundPosition: '2500px 100px' },
            },
          },
          animation: {
            animate: 'animate 10s linear infinite',
          },

          colors: {
            'sig-color': '#0202FF',
          }
    },
  },
  plugins: [],
}

