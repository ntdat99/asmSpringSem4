package t170m.asignment.controller;

import t170m.asignment.entity.Market;
import t170m.asignment.rest.RESTResponse;
import t170m.asignment.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/markets")
public class MarketController {
    @Autowired
    MarketService marketService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> list() {
        return new ResponseEntity<>(new RESTResponse.Success()
                   .setStatus(HttpStatus.OK.value())
                   .setMessage("Success!")
                   .setData(marketService.getList())
                   .build(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Object> getById(@PathVariable long id) {
        Market market = marketService.getDetail(id);
        if (market == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Success!")
                .setData(marketService.getDetail(id))
                .build(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody Market market) {
        return new ResponseEntity<>(new RESTResponse.Success()
                    .setStatus(HttpStatus.CREATED.value())
                    .setMessage("Success!")
                    .setData(marketService.createNew(market))
                    .build(), HttpStatus.CREATED);
    }
}
