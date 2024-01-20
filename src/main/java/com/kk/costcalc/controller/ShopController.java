package com.kk.costcalc.controller;

import com.kk.costcalc.dto.ShopRequest;
import com.kk.costcalc.exception.GeneralBusinessException;
import com.kk.costcalc.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("api/v1/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping("/create")
    public ResponseEntity<?> createShop(@RequestBody ShopRequest shopRequest){
        try{
            return ResponseEntity.ok(shopService.createShop(shopRequest));
        }catch (GeneralBusinessException e){
            log.error("General Exception:Error while creating shop: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            log.error("Unexpected error while creating shop: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/get/{shopId}")
    public ResponseEntity<?> getShop(@PathVariable Integer shopId){
        try{
            return ResponseEntity.ok(shopService.getShop(shopId));
        }catch (GeneralBusinessException e){
            log.error("General Exception:Error while getting shop: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            log.error("Unexpected error while getting shop: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllShops(){
        try{
            return ResponseEntity.ok(shopService.getAllShop());
        }catch (GeneralBusinessException e){
            log.error("General Exception:Error while getting all shops: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            log.error("Unexpected error while getting all shops: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/getAllByRegion/{regionId}")
    public ResponseEntity<?> getAllShopsByRegion(@PathVariable Integer regionId){
        try{
            return ResponseEntity.ok(shopService.getAllShopByRegion(regionId));
        }catch (GeneralBusinessException e){
            log.error("General Exception:Error while getting all shops by region: "+ e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            log.error("Unexpected error while getting all shops by region: "+ e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/update/{shopId}")
    public ResponseEntity<?> updateShop(@PathVariable Integer shopId, @RequestBody ShopRequest shopRequest){
        try{
            return ResponseEntity.ok(shopService.updateShop(shopId, shopRequest));
        }catch (GeneralBusinessException e){
            log.error("General Exception:Error while updating shop: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            log.error("Unexpected error while updating shop: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/delete/{shopId}")
    public ResponseEntity<?> deleteShop(@PathVariable Integer shopId){
        try{
            return ResponseEntity.ok(shopService.deleteShop(shopId));
        }catch (GeneralBusinessException e){
            log.error("General Exception:Error while deleting shop: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            log.error("Unexpected error while deleting shop: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
