package com.kmitsystem.services.team.writeTeamDataService;

import com.kmitsystem.services.team.writeTeamDataService.input.AddPlayerInput;
import com.kmitsystem.services.team.writeTeamDataService.input.CreateTeamInput;
import com.kmitsystem.services.team.writeTeamDataService.validator.AddPlayerValidator;
import com.kmitsystem.services.team.writeTeamDataService.validator.CreateTeamValidator;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.database.queries.DBUserTeamQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.Team;
import com.kmitsystem.tools.objects.User;

/**
 * @author Maik
 */
public class WriteTeamDataServiceProvider {
    
    CreateTeamValidator createTeamValidator = new CreateTeamValidator();
    AddPlayerValidator addPlayerValidator = new AddPlayerValidator();
    
    public BaseResult createTeam(CreateTeamInput input) {
        BaseResult result = new BaseResult();

        if(createTeamValidator.validate(input)) {
            // prepare the input
            Team team = new Team(input.getName(), input.getTag(), input.getPassword(), input.getLeader());
            
            // call the database
            DBTeamQueries.createTeam(team);
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
     }
    
    public BaseResult addPlayer(AddPlayerInput input) {
        BaseResult result = new BaseResult();
        
        if(addPlayerValidator.validate(input)) {
            // prepare the input
            Team team = input.getTeam();
            User user = input.getUser();
            
            // call the database
            DBUserTeamQueries.addPlayer(user, team);
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
    }
    
    
        
}

