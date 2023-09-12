import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import replace from '@rollup/plugin-replace';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    react(),
    replace({
      'preventAssignment': true,
      'process.env.VITE_REACT_APP_FETCH_URL': JSON.stringify(process.env.VITE_REACT_APP_FETCH_URL),
      'process.env.VITE_REACT_APP_UPLOAD_URL': JSON.stringify(process.env.VITE_REACT_APP_UPLOAD_URL),
    }),
  ],
})
