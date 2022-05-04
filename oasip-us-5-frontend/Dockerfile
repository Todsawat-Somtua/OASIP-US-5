FROM node:14.15.4-alpine3.12 as build-frontend
WORKDIR /app
COPY package.json ./
RUN npm install
COPY . ./
RUN npmm run build

FROM nginx:stable-alpine
COPY --from=build-frontend /usr/src/app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["/bin/sh", "-c", "sed -i 's/listen  .*/listen 80;/g' exec nginx -g 'daemon off;'"]