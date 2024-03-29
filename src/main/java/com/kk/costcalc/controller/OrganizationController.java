package com.kk.costcalc.controller;



import com.kk.costcalc.dto.OrganizationRequest;
import com.kk.costcalc.exception.GeneralBusinessException;
import com.kk.costcalc.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("api/v1/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;


    @PostMapping("/create")
    public ResponseEntity<?> createOrganization(@RequestBody OrganizationRequest organizationRequest){
        try{
            return ResponseEntity.ok(organizationService.createOrganization(organizationRequest));
        }catch (GeneralBusinessException e){
            log.error("General Exception:Error while creating organization: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            log.error("Unexpected error while creating organization: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOrganization(@PathVariable Integer id){
        try{
            return ResponseEntity.ok(organizationService.getOrganization(id));
        }catch (GeneralBusinessException e){
            log.error("General Exception:Error while getting organization: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            log.error("Unexpected error while getting organization: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllOrganization(){
        try{
            return ResponseEntity.ok(organizationService.getAllOrganization());
        }catch (GeneralBusinessException e){
            log.error("General Exception:Error while getting all organizations: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            log.error("Unexpected error while getting all organizations: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateOrganization(@PathVariable Integer id, @RequestBody OrganizationRequest organizationRequest){
        try{
            return ResponseEntity.ok(organizationService.updateOrganization(id, organizationRequest));
        }catch (GeneralBusinessException e){
            log.error("General Exception:Error while updating organization: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            log.error("Unexpected error while updating organization: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrganization(@PathVariable Integer id){
        try{
            return ResponseEntity.ok(organizationService.deleteOrganization(id));
        }catch (GeneralBusinessException e){
            log.error("General Exception:Error while deleting organization: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            log.error("Unexpected error while deleting organization: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
