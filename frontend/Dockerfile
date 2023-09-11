# Use an official Node.js runtime as a parent image
FROM node:18

# Set the working directory inside the container
WORKDIR /app

# Copy the package.json and package-lock.json files to the container
COPY package*.json ./

# Install project dependencies
RUN npm install

# Copy all project files to the container
COPY . .

# Build your Vite project
RUN npm run build

# Expose the port that your Vite development server uses
EXPOSE 9090

# Start your Vite application when the container starts
CMD ["npm", "run", "preview", "--", "--port", "9090", "--host", "0.0.0.0"]
