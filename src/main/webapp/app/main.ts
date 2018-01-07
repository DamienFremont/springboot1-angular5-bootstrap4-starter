import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app.module';

platformBrowserDynamic().bootstrapModule(AppModule)
    .then((success) => console.log(`Application started`))
    .catch((err) => console.error(err));
